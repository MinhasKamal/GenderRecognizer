package com.minhaskamal.genderRecognizer;

import java.io.File;
import java.io.FilenameFilter;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import com.minhaskamal.genderRecognizer.weightedPixel.WeightedStandardPixelTrainer;


public class Test {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		WeightedStandardPixelTrainer weightedStandardPixelTrainer = new WeightedStandardPixelTrainer();
		weightedStandardPixelTrainer.load("src/res/knowledge/Knowledge.log");

		//sample file
		String testFolderPath = "src/res/trainingData";
		
		File testFolder = new File(testFolderPath);
		String[] testSubfolderPaths = testFolder.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		

		int id=0;	//label
		int right=0;
		int wrong=0;
		for(String SubfolderPath: testSubfolderPaths){
			File[] files = new File(testFolderPath+"\\"+SubfolderPath).listFiles();
			
			for(File file: files){
				String imageFilePath = file.getAbsolutePath();
				Mat mat = Highgui.imread(imageFilePath, Highgui.IMREAD_GRAYSCALE);
				
				int prediction = weightedStandardPixelTrainer.predict(mat);
				
				if(prediction==id){
					right++;
					System.out.print("R");
				}else{
					wrong++;
					System.out.println("W");
				}
			}
			
			id++;
		}
		
		System.out.println("Percentage of error: " + wrong*100/(wrong+right));
		
		System.out.println("Operation Successful!!!");
	}
}
