module com.jayce.vexis.tool {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires com.microsoft.onnxruntime;

    opens com.jayce.vexis.tool to javafx.fxml;
    opens com.jayce.vexis.tool.controll to javafx.fxml;
    exports com.jayce.vexis.tool;
}