package ru.spbau.farutin.anti_cp_task_plugin;

import com.intellij.codeInsight.editorActions.CopyPastePreProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.RawText;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This is an implementation of copy paste preprocessor
 * which shows warning message on every paste action.
 */
public class AntiCPPreProcessor implements CopyPastePreProcessor {
    private final static String TITLE = "Anti Copy Paste";
    private final static String MESSAGE = "Копипаста - зло!";

    @Nullable
    @Override
    public String preprocessOnCopy(PsiFile file, int[] startOffsets, int[] endOffsets, String text) {
        return null;
    }

    @NotNull
    @Override
    public String preprocessOnPaste(Project project, PsiFile file, Editor editor, String text, RawText rawText) {
        Messages.showMessageDialog(project, MESSAGE, TITLE, Messages.getWarningIcon());
        return text;
    }
}
