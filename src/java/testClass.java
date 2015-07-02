import java.io.File;
import org.opencv.contrib.FaceRecognizer;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

public class testClass {
    static{ System.load(new File("C:\\Users\\Paradox\\Documents\\NetBeansProjects\\Servlet3\\lib\\opencv_java249.dll").getAbsolutePath());}
    public static void main(String ... args) {
        Mat frame = new Mat();
        VideoCapture camera = new VideoCapture(0);
        camera.open(0);
        
        if(!camera.isOpened()){
            System.out.println("Camera Error");
        }
        camera.read(frame);
        System.out.println("Frame Grabbed");
        Highgui.imwrite("C:\\Users\\Paradox\\Documents\\NetBeansProjects\\Servlet3\\Images\\camera.jpg", frame);
        System.out.println("Captured Frame Width " + frame.width());
        camera.release();
        
        String face_cascade_name = "C:\\opencv\\data\\haarcascades\\haarcascade_frontalface_alt.xml";
        CascadeClassifier faceDetector = new CascadeClassifier(face_cascade_name);
        
        //Mat image=frame;
        Mat image=Highgui.imread("C:\\Users\\Paradox\\Desktop\\FD_S\\face.jpg");
        
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        Rect rectCrop = new Rect(0, 0, 0, 0);
        int file = 0;
        
        for (Rect rect : faceDetections.toArray()) {
            rectCrop = new Rect(rect.x, rect.y, rect.width, rect.height);
            Mat image_roi = new Mat(image,rectCrop);
            Highgui.imwrite("C:\\Users\\Paradox\\Documents\\NetBeansProjects\\Servlet3\\Images\\face_"+file+".jpg",image_roi);
            file++;
            //draw boxes on detected faces
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }
        
        String filename = "ouput";
        System.out.println(String.format("Writing %s.jpg", filename));
        Highgui.imwrite("C:\\Users\\Paradox\\Documents\\NetBeansProjects\\Servlet3\\Images\\ouput.jpg", image);
        
        Mat image_roi = new Mat(image,rectCrop);
        Highgui.imwrite("C:\\Users\\Paradox\\Documents\\NetBeansProjects\\Servlet3\\Images\\cropimage_"+filename+".jpg",image_roi);
    }
}
