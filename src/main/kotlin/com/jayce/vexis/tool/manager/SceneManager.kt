package com.jayce.vexis.tool.manager

import com.jayce.vexis.tool.MainApplication
import com.jayce.vexis.tool.enums.SceneType
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

object SceneManager {

    private var stage: Stage? = null
    var scene: Scene? = null
    private var currentType: SceneType? = null
    private val sceneMap = HashMap<SceneType, Scene>()

    fun setStage(mainStage: Stage) {
        this.stage = mainStage
    }

    @Synchronized
    fun loadScene(type: SceneType, width: Double, height: Double) {
        if (currentType == type) return
        val scene = sceneMap[type]
        if (scene != null) {
            update(scene, type)
            return
        }
        val loader = getSceneLoader(type)
        val currentScene = Scene(loader.load(), width, height)
        sceneMap[type] = currentScene
        update(currentScene, type)
    }

    private fun update(scene: Scene, type: SceneType) {
        this.scene = scene
        this.currentType = type
        stage?.scene = scene
    }

    fun <T> getNode(name: String): T {
        return getLoader(name).load() as T
    }

    private fun getSceneLoader(type: SceneType): FXMLLoader {
        val name = when (type) {
            SceneType.MAIN -> "mainView"
            SceneType.UTIL -> "utilView"
        }
        return getLoader(name)
    }

    private fun getLoader(name: String): FXMLLoader {
        val resourceName = "${name}.fxml"
        val loader = FXMLLoader(MainApplication::class.java.getResource(resourceName))
        return loader
    }
}