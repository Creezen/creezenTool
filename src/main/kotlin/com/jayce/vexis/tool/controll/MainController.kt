package com.jayce.vexis.tool.controll

import com.jayce.vexis.tool.enums.SceneType
import com.jayce.vexis.tool.manager.SceneManager.loadScene
import javafx.fxml.FXML
import javafx.scene.control.Label

class MainController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcdome to JavaFX Application!"
    }

    @FXML
    private fun onDismiss() {
        loadScene(SceneType.UTIL, 200.0, 200.0)
    }
}