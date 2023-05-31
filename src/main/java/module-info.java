module com.proyectohorarios2_0 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.proyectohorarios2_0 to javafx.fxml;
    exports com.proyectohorarios2_0;
}