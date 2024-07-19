package org.example

import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextPane

fun main() {
    val guiMain = GUIMain()
}

class GUIMain {
    var num1: String = ""
    var num2: String = ""
    var operator: String = ""
    val mainTextOutput = JTextPane()

    init {

        val mainGUIFrame = JFrame("Calculator")
        mainGUIFrame.setSize(400, 400)
        mainGUIFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        val mainGUIPanel = JPanel(BorderLayout())
        mainGUIFrame.add(mainGUIPanel)
        mainGUIPanel.add(mainTextOutput, BorderLayout.NORTH)

        val buttonPanel = JPanel(GridLayout(4, 4))
        mainGUIPanel.add(buttonPanel, BorderLayout.CENTER)

        val button1 = JButton("1")
        buttonPanel.add(button1)
        button1.addActionListener {
            retrieveValues("1")
        }

        val button2 = JButton("2")
        buttonPanel.add(button2)
        button2.addActionListener {
            retrieveValues("2")
        }

        val button3 = JButton("3")
        buttonPanel.add(button3)
        button3.addActionListener {
            retrieveValues("3")
        }

        val equalsButton = JButton("=")
        buttonPanel.add(equalsButton)
        equalsButton.addActionListener {
            num1 = calculate(num1, num2, operator).toString()
            updateDisplay(num1)
            operator = ""
            num2 = ""
        }

        val button4 = JButton("4")
        buttonPanel.add(button4)
        button4.addActionListener {
            retrieveValues("4")
        }

        val button5 = JButton("5")
        buttonPanel.add(button5)
        button5.addActionListener {
            retrieveValues("5")
        }

        val button6 = JButton("6")
        buttonPanel.add(button6)
        button6.addActionListener {
            retrieveValues("6")
        }

        val plusButton = JButton("+")
        buttonPanel.add(plusButton)
        plusButton.addActionListener {
            retrieveValues("+")
        }

        val button7 = JButton("7")
        buttonPanel.add(button7)
        button7.addActionListener {
            retrieveValues("7")
        }

        val button8 = JButton("8")
        buttonPanel.add(button8)
        button8.addActionListener {
            retrieveValues("8")
        }

        val button9 = JButton("9")
        buttonPanel.add(button9)
        button9.addActionListener {
            retrieveValues("9")
        }

        val minusButton = JButton("-")
        buttonPanel.add(minusButton)
        minusButton.addActionListener {
            retrieveValues("-")
        }

        val periodButton = JButton(".")
        buttonPanel.add(periodButton)
        periodButton.addActionListener {
            retrieveValues(".")
        }

        val button0 = JButton("0")
        buttonPanel.add(button0)
        button0.addActionListener {
            retrieveValues("0")
        }

        val multiplyButton = JButton("*")
        buttonPanel.add(multiplyButton)
        multiplyButton.addActionListener {
            retrieveValues("*")
        }

        val divideButton = JButton("/")
        buttonPanel.add(divideButton)
        divideButton.addActionListener {
            retrieveValues("/")
        }

        mainGUIFrame.isVisible = true

    }

    fun updateDisplay(input: String) {
        mainTextOutput.text = input
    }


    fun calculate(operand1: String, operand2: String, operator: String): Double {
        val value1 = operand1.toDouble()
        val value2 = operand2.toDouble()
        return when (operator) {
            "+" -> value1 + value2
            "-" -> value1 - value2
            "*" -> value1 * value2
            "/" -> value1 / value2
            else -> 0.0
        }
    }

    fun retrieveValues(command: String) {

        if (operator.isEmpty()) {
            val number = command.toDoubleOrNull()
            if (number != null) {
                num1 = num1 + "$command"
                updateDisplay("$num1")
            } else {
                operator = command
                updateDisplay(operator)
            }
        } else {
            num2 = num2 + "$command"
            updateDisplay("$num2")
        }
    }
}