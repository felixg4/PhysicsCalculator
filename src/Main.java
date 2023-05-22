import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) {

        Label v0Label;
        Label v1Label;
        Label tLabel;
        Label dLabel;
        Label aLabel;
        TextField initVel;
        TextField finalVel;
        TextField time;
        TextField dist;
        TextField accel;
        Button calculate;
        VBox vbox;
        Scene scene;

        initVel = new TextField("");
        finalVel = new TextField("");
        time = new TextField("");
        dist = new TextField("");
        accel = new TextField("");

        v0Label = new Label("Initial Velocity");
        v1Label = new Label("Final Velocity");
        tLabel = new Label("Time");
        dLabel = new Label("Distance");
        aLabel = new Label("Acceleration");
        calculate = new Button("Click to calculate");

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (initVel.getText().equals("")) {
                    double v1 = Double.parseDouble(finalVel.getText());
                    double t = Double.parseDouble(time.getText());
                    double a = Double.parseDouble(accel.getText());
                    double res = Physics.findInitVel(v1, t, a);
                    initVel.setText(String.valueOf(res));
                } else if (finalVel.getText().equals("")) {
                    double vi = Double.parseDouble(initVel.getText());
                    double a = Double.parseDouble(accel.getText());
                    double t = Double.parseDouble(time.getText());
                    finalVel.setText(String.valueOf(Physics.findFinalVel(vi, a, t)));
                } else if (time.getText().equals("")) {
                    time.setText(String.valueOf(Physics.findTime(Double.parseDouble(initVel.getText()), Double.parseDouble(finalVel.getText()), Double.parseDouble(accel.getText()))));
                } else if (accel.getText().equals("")) {
                    double vi = Double.parseDouble(initVel.getText());
                    double t = Double.parseDouble(time.getText());
                    double vf = Double.parseDouble(finalVel.getText());
                    accel.setText(String.valueOf(Physics.findAcceleration(vi, vf, t)));
                } else if (dist.getText().equals("")) {
                    double vi = Double.parseDouble(initVel.getText());
                    double a = Double.parseDouble(accel.getText());
                    double t = Double.parseDouble(time.getText());
                    dist.setText(String.valueOf(Physics.findDistance(vi, a, t)));
                }
            }
        });

        vbox = new VBox(v0Label, initVel, v1Label, finalVel, tLabel, time, dLabel, dist, aLabel, accel, calculate);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        scene = new Scene(vbox, 500, 500);

        primaryStage.setTitle("Kinematics Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
