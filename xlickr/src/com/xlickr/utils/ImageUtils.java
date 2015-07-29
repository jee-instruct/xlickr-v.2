package com.xlickr.utils;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.common.ImageMetadata.ImageMetadataItem;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ImageUtils {
	
	private static Map<String,String> props = new HashMap<String,String>();
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getImageMetadata(byte[] bytes){
		props.clear();
		try {
			final ImageMetadata metadata = Imaging.getMetadata(bytes);
			if(null!=metadata){
			final List<ImageMetadataItem> items = (List<ImageMetadataItem>) metadata.getItems();
			for(ImageMetadataItem item : items){
				String[] parts = item.toString().split(":");
				props.put(parts[0].trim(), parts[1].replace("\'", "").trim());
			 }
			}else{
				extractMetadataUsingImageIO(bytes);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return props;
	}
	
	
	public static void extractMetadataUsingImageIO(byte[] bytes){
		try{
			ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(bytes));
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                reader.setInput(iis, true);
                IIOMetadata metadata = reader.getImageMetadata(0);
                String[] names = metadata.getMetadataFormatNames();
                int length = names.length;
                for (int i = 0; i < length; i++) {
                    displayMetadata(metadata.getAsTree(names[i]),0);
                }
            }
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void displayMetadata(Node node, int level) {
		NamedNodeMap map = node.getAttributes();
        if (map != null) {
            int length = map.getLength();
            for (int i = 0; i < length; i++) {
                Node attr = map.item(i);
                props.put(attr.getNodeName(), attr.getNodeValue());
            }
        }
        
        Node child = node.getFirstChild();
        if (child == null) {
            return;
        }
        while (child != null) {
            displayMetadata(child, level + 1);
            child = child.getNextSibling();
        }
        
        
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
