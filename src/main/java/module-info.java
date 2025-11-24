module projeto.gerenciadordeestoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
//    requires projeto.gerenciadordeestoque;
    exports projeto.gerenciadordeestoque.DAO;
    exports projeto.gerenciadordeestoque.entity;
    exports projeto.gerenciadordeestoque.jdbc;



    opens projeto.gerenciadordeestoque to javafx.fxml;
    exports projeto.gerenciadordeestoque;

    opens projeto.gerenciadordeestoque.controllers to javafx.fxml;
    exports projeto.gerenciadordeestoque.controllers;
}