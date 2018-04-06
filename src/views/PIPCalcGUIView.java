package views;

import controllers.PIPCalcController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import processors.PIPCalcInfixProcessor;
import processors.PIPCalcPostfixProcessor;
import processors.PIPCalcPrefixProcessor;
import processors.PIPCalcProcessor;

import java.util.Observable;
import java.util.Observer;

/**
 * PIPCalcGUI for the PIPCalc project.
 *
 * @author Daniel Porten
 */
public class PIPCalcGUIView extends Application implements Observer {
    /**
     * The controller for interface between the view and the model.
     */
    private PIPCalcController controller;
    /**
     * The expression currently stored for use.
     */
    private String calcExp;
    /**
     * A display for user messages and expression display.
     */
    private TextField calcDisplay;
    /**
     * Infix processor.
     */
    private PIPCalcProcessor infix;
    /**
     * Prefix processor.
     */
    private PIPCalcProcessor prefix;
    /**
     * Postfix Processor.
     */
    private PIPCalcProcessor postfix;

    /**
     * Constructs the GUI.
     * Makes three processor models, connects the controller to the infix model.
     */
    public PIPCalcGUIView(){
        infix = new PIPCalcInfixProcessor();
        prefix = new PIPCalcPrefixProcessor();
        postfix = new PIPCalcPostfixProcessor();
        controller = new PIPCalcController(infix);
        changeModel(infix);
    }

    /**
     * Changes the current model.
     * Removes this as an observer from all models, then adds it as an observer of the new model.
     * @param model The model to change to.
     */
    private void changeModel(PIPCalcProcessor model){
        infix.deleteObserver(this);
        prefix.deleteObserver(this);
        postfix.deleteObserver(this);
        controller.changeModel(model);
        model.addObserver(this);
    }

    /**
     * Updates the GUI based on the model.
     * @param o
     * @param arg the string to display onthe calculator.
     */
    @Override
    public void update(Observable o, Object arg) {
        String argstring = (String)(arg);
        updateDisplay("");
        updateDisplay(argstring);
    }

    /**
     * Builds and starts the GUI.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();

        makeDisplay();
        borderPane.setTop(calcDisplay);
        borderPane.setRight(makeInputMode());
        borderPane.setLeft(makeButtons());


        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("PIPCalc");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Constructs and sets up the expression display window.
     */
    private void makeDisplay(){
        calcExp = "";
        calcDisplay = new TextField(calcExp);
        calcDisplay.setEditable(false);
        calcDisplay.setAlignment(Pos.CENTER_RIGHT);
    }

    /**
     * Constructs and returns the input mode buttons.
     * @return
     */
    private VBox makeInputMode(){
        VBox inputMode = new VBox();
        ToggleGroup inputModeGroup = new ToggleGroup();
        RadioButton InfixMode = new RadioButton("Infix");
        InfixMode.setOnAction(event -> changeModel(infix));
        RadioButton PrefixMode = new RadioButton("Prefix");
        PrefixMode.setOnAction(event -> changeModel(prefix));
        RadioButton PostfixMode = new RadioButton("Postfix");
        PostfixMode.setOnAction(event -> changeModel(postfix));
        InfixMode.setToggleGroup(inputModeGroup);
        PrefixMode.setToggleGroup(inputModeGroup);
        PostfixMode.setToggleGroup(inputModeGroup);
        inputMode.getChildren().addAll(InfixMode,PrefixMode,PostfixMode);
        InfixMode.setSelected(true);
        return inputMode;
    }

    /**
     * Constructs and returns the control buttons.
     * @return
     */
    private GridPane makeButtons(){
        GridPane buttonpane = new GridPane();

        Button button1 = new Button("1");
        button1.setPrefWidth(50);
        button1.setOnAction(( ActionEvent event ) -> updateDisplay("1"));
        buttonpane.add(button1,1,1);

        Button button2 = new Button("2");
        button2.setPrefWidth(50);
        button2.setOnAction(( ActionEvent event ) -> updateDisplay("2"));
        buttonpane.add(button2,2,1);

        Button button3 = new Button("3");
        button3.setPrefWidth(50);
        button3.setOnAction(( ActionEvent event ) -> updateDisplay("3"));
        buttonpane.add(button3,3,1);

        Button buttonplus = new Button("+");
        buttonplus.setPrefWidth(50);
        buttonplus.setOnAction(( ActionEvent event ) -> updateDisplay("+"));
        buttonpane.add(buttonplus,4,1);

        Button button4 = new Button("4");
        button4.setPrefWidth(50);
        button4.setOnAction(( ActionEvent event ) -> updateDisplay("4"));
        buttonpane.add(button4,1,2);

        Button button5 = new Button("5");
        button5.setPrefWidth(50);
        button5.setOnAction(( ActionEvent event ) -> updateDisplay("5"));
        buttonpane.add(button5,2,2);

        Button button6 = new Button("6");
        button6.setPrefWidth(50);
        button6.setOnAction(( ActionEvent event ) -> updateDisplay("6"));
        buttonpane.add(button6,3,2);

        Button buttonminus = new Button("-");
        buttonminus.setPrefWidth(50);
        buttonminus.setOnAction(( ActionEvent event ) -> updateDisplay("-"));
        buttonpane.add(buttonminus,4,2);

        Button button7 = new Button("7");
        button7.setPrefWidth(50);
        button7.setOnAction(( ActionEvent event ) -> updateDisplay("7"));
        buttonpane.add(button7,1,3);

        Button button8 = new Button("8");
        button8.setPrefWidth(50);
        button8.setOnAction(( ActionEvent event ) -> updateDisplay("8"));
        buttonpane.add(button8,2,3);

        Button button9 = new Button("9");
        button9.setPrefWidth(50);
        button9.setOnAction(( ActionEvent event ) -> updateDisplay("9"));
        buttonpane.add(button9,3,3);

        Button buttonmult = new Button("*");
        buttonmult.setPrefWidth(50);
        buttonmult.setOnAction(( ActionEvent event ) -> updateDisplay("*"));
        buttonpane.add(buttonmult,4,3);

        Button buttonEnter = new Button("Enter");
        buttonEnter.setPrefWidth(50);
        buttonEnter.setOnAction(( ActionEvent event ) -> proccessExpression());
        buttonpane.add(buttonEnter,1,4);

        Button button0 = new Button("0");
        button0.setPrefWidth(50);
        button0.setOnAction(( ActionEvent event ) -> updateDisplay("0"));
        buttonpane.add(button0,2,4);

        Button buttonClear = new Button("Clear");
        buttonClear.setPrefWidth(50);
        buttonClear.setOnAction(( ActionEvent event ) -> updateDisplay(""));
        buttonpane.add(buttonClear,3,4);

        Button buttondiv = new Button("//");
        buttondiv.setPrefWidth(50);
        buttondiv.setOnAction(( ActionEvent event ) -> updateDisplay("//"));
        buttonpane.add(buttondiv,4,4);

        Button buttonless = new Button("<");
        buttonless.setPrefWidth(50);
        buttonless.setOnAction(( ActionEvent event ) -> updateDisplay("<"));
        buttonpane.add(buttonless,1,5);

        Button buttonlessequal = new Button("<=");
        buttonlessequal.setPrefWidth(50);
        buttonlessequal.setOnAction(( ActionEvent event ) -> updateDisplay("<="));
        buttonpane.add(buttonlessequal,2,5);

        Button buttonnotequal = new Button("!=");
        buttonnotequal.setPrefWidth(50);
        buttonnotequal.setOnAction(( ActionEvent event ) -> updateDisplay("!="));
        buttonpane.add(buttonnotequal,3,5);

        Button buttonpower = new Button("^");
        buttonpower.setPrefWidth(50);
        buttonpower.setOnAction(( ActionEvent event ) -> updateDisplay("^"));
        buttonpane.add(buttonpower,4,5);

        Button buttonequals = new Button("==");
        buttonequals.setPrefWidth(50);
        buttonequals.setOnAction(( ActionEvent event ) -> updateDisplay("=="));
        buttonpane.add(buttonequals,1,6);

        Button buttongreater = new Button(">");
        buttongreater.setPrefWidth(50);
        buttongreater.setOnAction(( ActionEvent event ) -> updateDisplay(">"));
        buttonpane.add(buttongreater,2,6);

        Button buttongreaterequals = new Button(">=");
        buttongreaterequals.setPrefWidth(50);
        buttongreaterequals.setOnAction(( ActionEvent event ) -> updateDisplay(">="));
        buttonpane.add(buttongreaterequals,3,6);

        Button buttonnegation = new Button("_");
        buttonnegation.setPrefWidth(50);
        buttonnegation.setOnAction(( ActionEvent event ) -> updateDisplay("_"));
        buttonpane.add(buttonnegation,4,6);

        Button buttonsqrt = new Button("@");
        buttonsqrt.setPrefWidth(50);
        buttonsqrt.setOnAction(( ActionEvent event ) -> updateDisplay("@"));
        buttonpane.add(buttonsqrt,1,7);

        Button buttonabs = new Button("|");
        buttonabs.setPrefWidth(50);
        buttonabs.setOnAction(( ActionEvent event ) -> updateDisplay("|"));
        buttonpane.add(buttonabs,2,7);

        Button spaceButton = new Button("Space");
        spaceButton.setPrefWidth(100);
        spaceButton.setOnAction(( ActionEvent event ) -> updateDisplay(" "));
        buttonpane.add(spaceButton,3,7);
        buttonpane.setColumnSpan(spaceButton,2);

        Button toInfixbutton = new Button("ToInfix");
        toInfixbutton.setPrefWidth(200);
        toInfixbutton.setOnAction(( ActionEvent event ) -> controller.convert(calcExp,"infix"));
        buttonpane.add(toInfixbutton,1,8);
        buttonpane.setColumnSpan(toInfixbutton,4);

        Button toPrefixbutton = new Button("ToPrefix");
        toPrefixbutton.setPrefWidth(200);
        toPrefixbutton.setOnAction(( ActionEvent event ) -> controller.convert(calcExp,"prefix"));
        buttonpane.add(toPrefixbutton,1,9);
        buttonpane.setColumnSpan(toPrefixbutton,4);

        Button toPostfixbutton = new Button("ToPostfix");
        toPostfixbutton.setPrefWidth(200);
        toPostfixbutton.setOnAction(( ActionEvent event ) -> controller.convert(calcExp,"postfix"));
        buttonpane.add(toPostfixbutton,1,10);
        buttonpane.setColumnSpan(toPostfixbutton,4);

        return buttonpane;
    }

    /**
     * Attempts to process the current expression storec in the GUI.
     * Catches ArithmeticExpressions and displays them.
     */
    private void proccessExpression(){
        try{
            controller.process(calcExp);
        }
        catch (ArithmeticException mathserror){
            calcExp = "";
            calcDisplay.setText("");
            calcDisplay.setText(mathserror.getMessage());
        }
    }

    /**
     * Updates the display by concatenating the provided string.
     * @param arg String to change the display with.
     */
    private void updateDisplay(String arg){
        if ("".equals(arg)){
            calcExp = "";
        }
        else{
            calcExp += arg;
        }
        calcDisplay.setText(calcExp);
    }
}
