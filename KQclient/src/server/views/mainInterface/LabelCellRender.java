package server.views.mainInterface;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class LabelCellRender extends JLabel implements ListCellRenderer{
	
	public LabelCellRender()
	{
		this.setOpaque(true);
	}
	public Component getListCellRendererComponent(JList list, Object value,int index, boolean isSelected, boolean cellHasFocus)
	{
		if(value != null)
		{
			setText(value.toString());
			setIcon(new ImageIcon("pic//main//"+(index+2)+".png"));
			
		}
		if(isSelected)
		{
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}
		return this;
	}
}
