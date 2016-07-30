package tests;

import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

import interfaces.CameraReader;

public class Camera implements CameraReader{

	private String nextImage;
	
	@Override
	public Mat getImage() {
		if(nextImage == null)
			return null;
		return Highgui.imread(nextImage);
	}
	
	public void setNextImage(String nextImage){
		this.nextImage = this.getClass().getClassLoader().getResource(nextImage).getPath();
	}

}
