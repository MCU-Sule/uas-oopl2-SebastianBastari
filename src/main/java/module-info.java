module com.example.uaspbo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.example.uaspbo2 to javafx.fxml;
    exports com.example.uaspbo2;
    exports com.example.uaspbo2.model;
}