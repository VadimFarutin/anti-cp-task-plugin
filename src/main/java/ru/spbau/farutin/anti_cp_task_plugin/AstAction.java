package ru.spbau.farutin.anti_cp_task_plugin;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.YamlPrinter;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents action which shows AST for selected piece of code.
 */
public class AstAction extends AnAction {
    private final static String TITLE = "AST for Selected Code";
    private final static String EMPTY_TEXT = "";
    private final static String FAIL_MESSAGE = "Failed to build AST.";
    private YamlPrinter printer = new YamlPrinter(true);

    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();
        Editor editor = event.getData(CommonDataKeys.EDITOR);

        if (project == null || editor == null) {
            return;
        }

        String message;

        try {
            String selectedText = editor.getSelectionModel().getSelectedText();
            if (selectedText == null) {
                selectedText = EMPTY_TEXT;
            }

            CompilationUnit compilationUnit = StaticJavaParser.parse(selectedText);
            message = printer.output(compilationUnit);
        } catch (Exception e) {
            message = FAIL_MESSAGE;
        }

        Messages.showMessageDialog(project, message, TITLE, Messages.getInformationIcon());
    }
}
