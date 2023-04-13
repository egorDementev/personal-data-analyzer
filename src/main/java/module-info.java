module com.example.javalab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.javalab3 to javafx.fxml;
    exports com.example.javalab3;
}