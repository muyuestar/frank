package com.frank.swt.ocx;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 *
 * @author kst
 * @date 2021-06-28 16:33:15
 */
public class ConfirmHint {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell(display, SWT.CLOSE);
		shell.setText("sample");
		shell.setLayout(new FillLayout());
		shell.setSize(new Point(800, 600));

		shell.addShellListener(new ShellAdapter() {
			public void shellClosed(final ShellEvent e) {
				MessageBox box = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK | SWT.CANCEL);
				box.setText("选择");
				box.setMessage("确定退出？");
				int choice = box.open();
				// true-取消时关闭界面，false-取消时不关闭界面
				e.doit = false;
				System.out.println(choice == SWT.OK ? "YES" : "NO");
				shell.dispose();
			}
		});

		shell.open();
		System.out.println("open");

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
