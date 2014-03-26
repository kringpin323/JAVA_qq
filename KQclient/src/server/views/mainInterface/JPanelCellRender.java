package server.views.mainInterface;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

class JPanelCellRender extends JLabel implements ListCellRenderer
{

	public JPanelCellRender(){
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}
	
	public Component getListCellRendererComponent(JList list,Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		if(value!= null && value instanceof JPanel)
		{
			if(isSelected)//设置选中时的颜色
			{
				((JPanel)value).setBackground(Color.LIGHT_GRAY);
			}else
			{
				((JPanel)value).setBackground(Color.white);
			}
			return (JPanel)value;
		}
		return this;
	}

}
