module com.example.pennyplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires java.mail;


    opens com.example.pennyplanner to javafx.fxml;
    exports com.example.pennyplanner;
}