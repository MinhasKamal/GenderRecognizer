/************************************************************************************************************************
* Developer: Minhas Kamal(BSSE-0509, IIT, DU)																			*
* Date: 08-Sep-2014																										*
*************************************************************************************************************************/

package com.minhaskamal.genderRecognizer.weightedPixel;

import java.io.FileWriter;
import java.io.IOException;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;

public class WeightedStandardImage {
	private int types;
	private Size size;
	private int[] ids;
	private int[] weights;
	private Mat[] standardImages;
	
	
	public WeightedStandardImage(int types, Size size) {
		this.types = types;
		this.size = size;
		this.ids = new int[types];
		this.weights = new int[types];
		this.standardImages = new Mat[types];
		for(int i=0; i<types; i++){
			standardImages[i] = new Mat(size, Highgui.CV_LOAD_IMAGE_GRAYSCALE);
		}
	}
	
	public WeightedStandardImage() {
		this.types = 0;
		this.size = new Size(0, 0);
		this.ids = new int[types];
		this.weights = new int[types];
		this.standardImages = new Mat[types];
		for(int i=0; i<types; i++){
			standardImages[i] = new Mat(size, Highgui.CV_LOAD_IMAGE_GRAYSCALE);
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String dump(){
		int rows = (int) size.height, cols = (int) size.width;
		String content = "<WeightedStandardImage/>\n<types>" + types + "</types>\n<size>" +
				rows + "," + cols + "</size>\n<data>";
		
		String imageType = "";
		String line = "";
		for(int i=0; i<types; i++){
			imageType = "\n<id>" + ids[i] + "</id>\n" +
						"<weight>" + weights[i] + "</weight>\n" +
						"<stdImage>\n";
			
			for(int row=0; row<rows; row++){
				line = "";
				for(int col=0; col<cols; col++){
					line = line + (short)standardImages[i].get(row, col)[0] + ",";
				}
				imageType = imageType + line + "\n";
			}
			
			content = content + imageType + "</stdImage>\n";
		}
		
		content = content + "</data>";
		
		return content;
	}
	
	
	public void saveKnowledge(String filePath){
		System.out.println("Saving Knowledge...");	//notification
		
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(dump());
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//getter//setters//
	
	public int getTypes(){
		return types;
	}
	
	public Size getSize(){
		return size;
	}
	
	public int getId(int index){
		if(index<types){
			return ids[index];
		}else{
			return -1;
		}
	}
	
	public void setId(int index, int id){
		if(index<types){
			ids[index] = id;
		}
	}
	
	public int getWeight(int index){
		if(index<types){
			return weights[index];
		}else{
			return -1;
		}
	}
	
	public void setWeight(int index, int weight){
		if(index<types){
			weights[index] = weight;
		}
	}
	
	public void incrementWeight(int index){
		if(index<types){
			weights[index]++;
		}
	}
	
	public void setStandardImages(int index, int row, int col, short pixel){
		if(index<types){
			standardImages[index].put(row, col, pixel);
		}
	}
	
	public void setStandardImages(Mat newMat, int index){
		if(index<types){
			standardImages[index] = newMat;
		}
	}
	
	public short getStandardImages(int index, int row, int col){
		if(index<types && row<size.width && col<size.height){
			return (short) standardImages[index].get(row, col)[0];
		}else{
			return 0;
		}
	}
	
	public Mat getStandardImages(int index){
		if(index<types){
			return standardImages[index];
		}else{
			return null;
		}
	}
	
	
	//test only
	public static void main(String[] args) {
		WeightedStandardImage weightedStandardImage = new WeightedStandardImage(5, new Size(40, 40));
		
		System.out.println(weightedStandardImage.dump());
	}
}
