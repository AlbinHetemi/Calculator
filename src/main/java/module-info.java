module com.example.cactttuscalculator2022javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cactttuscalculator2022javafx to javafx.fxml;
    exports com.example.cactttuscalculator2022javafx;
}