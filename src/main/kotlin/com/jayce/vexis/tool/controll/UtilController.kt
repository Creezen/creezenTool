package com.jayce.vexis.tool.controll

import com.jayce.vexis.tool.enums.SceneType
import com.jayce.vexis.tool.manager.SceneManager.loadScene
import javafx.fxml.FXML
import javafx.scene.control.Label

class UtilController {

    @FXML
    private lateinit var desc: Label

    @FXML
    fun onBack() {
        loadScene(SceneType.MAIN, 400.0, 200.0)
    }

}