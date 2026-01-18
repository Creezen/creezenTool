package com.jayce.vexis.tool.controll

import ai.onnxruntime.*
import com.jayce.vexis.tool.MainApplication
import com.jayce.vexis.tool.enums.SceneType
import com.jayce.vexis.tool.manager.SceneManager
import com.jayce.vexis.tool.manager.SceneManager.getNode
import com.jayce.vexis.tool.manager.SceneManager.loadScene
import javafx.event.Event
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.control.TextField
import javafx.scene.input.DragEvent
import javafx.scene.input.TransferMode
import javafx.scene.layout.VBox
import java.io.File

class MainController {

    @FXML
    lateinit var add: Button

    @FXML
    lateinit var sum: Label

    @FXML
    lateinit var num1: TextField

    @FXML
    lateinit var num2: TextField

    @FXML
    lateinit var filePath: TextField

    @FXML
    lateinit var second: Tab

    @FXML
    lateinit var first: Tab

    @FXML
    lateinit var content: VBox
    
    @FXML
    private fun onChange() {
        loadScene(SceneType.UTIL, 400.0, 200.0)
    }

    @FXML
    private fun changeFirst(event: Event) {
        if (first.isSelected && ::content.isInitialized) {
            content.children.clear()
            content.children.add(getNode("first"))
        }
    }

    @FXML
    private fun changeSecond(event: Event) {
        if (second.isSelected) {
            content.children.clear()
            content.children.add(getNode("second"))
        }
    }

    @FXML
    fun onFileEnter(dragEvent: DragEvent) {
        val board = dragEvent.dragboard
        if (board.hasFiles()) {
            filePath.text = board.files[0].absolutePath
        }
    }

    @FXML
    fun onOver(dragEvent: DragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY[0],TransferMode.ANY[1], TransferMode.ANY[2])
    }

    @FXML
    fun addSum() {
        val env = OrtEnvironment.getEnvironment()
        val session = env.createSession(filePath.text)
        val arr = floatArrayOf(num1.text.toFloat(), num2.text.toFloat())
        val input = Array(1) {arr}
        val tensorX = OnnxTensor.createTensor(env, input)
        val result = session.run(mapOf("input" to tensorX))
        val out = result.get("output").get().value as Array<FloatArray>
        sum.text = out[0][0].toString()
    }
}