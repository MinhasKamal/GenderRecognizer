package com.minhaskamal.genderRecognizer;


import org.opencv.core.*;
import org.opencv.objdetect.*;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;


public class FaceDetector {
	
	public Mat[] snipFace(String image, Size size){
		
		Mat matImage = Highgui.imread(image, Highgui.IMREAD_UNCHANGED);
		
		Rect[] rectFace = detectFace(matImage);
		int rectFaceLength = rectFace.length;

		Mat[] matFace = new Mat[rectFaceLength];
		
		for(int i=0; i<rectFaceLength; i++){
			
			matFace[i] = matImage.submat(rectFace[i]);
			Imgproc.resize(matFace[i], matFace[i], size);
			
			//Highgui.imwrite(image.substring(0, image.length()-4)+"Snipped"+i+image.substring(image.length()-4), matFace[i]);
		}
		
		return matFace;
	}
	
	
	private Rect[] detectFace(Mat matImage){
		
		MatOfRect faces = new MatOfRect();
		//C:\Users\admin\Desktop\My_Java_Programs\ObjectRecognition\resource\data
		String HumanFace4 = "src/res/knowledge/haarcascade_frontalface_alt.xml";
		
		CascadeClassifier cascadeClassifier = new CascadeClassifier(HumanFace4);

		cascadeClassifier.detectMultiScale(matImage, faces , 1.1, 10, Objdetect.CASCADE_DO_CANNY_PRUNING, new Size(20, 20),
				matImage.size());
		
		//System.out.println(faces.dump());///test
		
		return faces.toArray();
	}
	
	///test
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String imagePath = "C:\\Users\\admin\\Desktop\\a.png";
		
		FaceDetector faceDetector = new FaceDetector();
		Mat[] mats = faceDetector.snipFace(imagePath, new Size(90, 90));
		
		int i=0;
		for(Mat mat: mats){
			Highgui.imwrite(imagePath.substring(0, imagePath.length()-4)+"Snipped"+i+imagePath.substring(imagePath.length()-4),
					mat);
			
			i++;
		}

		System.out.println("Done!!!");
	}
}
