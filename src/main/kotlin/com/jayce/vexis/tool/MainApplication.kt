package com.jayce.vexis.tool

import com.jayce.vexis.tool.enums.SceneType
import com.jayce.vexis.tool.manager.SceneManager
import com.jayce.vexis.tool.manager.SceneManager.loadScene
import com.jayce.vexis.tool.manager.SceneManager.setStage
import javafx.application.Application
import javafx.stage.Stage

class MainApplication : Application() {

    override fun start(stage: Stage) {
        setStage(stage)
        loadScene(SceneType.MAIN, 400.0, 200.0)
        val scene = SceneManager.scene
        stage.title = "日志分析工具"
        SceneManager.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(MainApplication::class.java)
}