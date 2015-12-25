package com.minhaskamal.genderRecognizer;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;

import com.minhaskamal.genderRecognizer.weightedPixel.WeightedStandardPixelTrainer;


public class Predict {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		WeightedStandardPixelTrainer weightedStandardPixelTrainer = new WeightedStandardPixelTrainer();

		//sample file
		String imageFilePath = "src/res/sample/sample.jpg";
		Mat[] faces = new FaceDetector().snipFace(imageFilePath, new Size(90, 90));
		
		
		//experience file
		weightedStandardPixelTrainer.load("src/res/knowledge/Knowledge.log");
		
		int faceNo=1;
		for(Mat face: faces){
			
			int prediction = weightedStandardPixelTrainer.predict(face);
			
			if(prediction==-1){
				System.out.println("I think " + faceNo + " is not a face.");
				Highgui.imwrite("src/res/sample/" + faceNo + "_noface.jpg", face);
			}else if(prediction==0){
				System.out.println("I think " + faceNo + " is a female.");
				Highgui.imwrite("src/res/sample/" + faceNo + "_female.jpg", face);
			}else{
				System.out.println("I think " + faceNo + " is a male.");
				Highgui.imwrite("src/res/sample/" + faceNo + "_male.jpg", face);
			}
			
			faceNo++;
		}
		
		System.out.println("Operation Successful!!!");
	}
}
