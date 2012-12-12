package cn.edu.buaa.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JCheckListBox extends JList {
	//这个boolean数组装载所有item是否被check的信息。
	  
	      private boolean[] checkedItems = null;
	 
	   /**
	      * 定义一个简单的ListModel,它可以发送check变化事件。
	     */
	   class CheckListBoxModel extends AbstractListModel {
	
	         private Object[] items = null;
	
	         CheckListBoxModel(Object[] items) {
	            this.items = items;
	        }
	
	         public int getSize() {
	             return items.length;
	         }
	 
	         public Object getElementAt(int i) {
	             return items[i];
	        }
	 
	         protected void fireCheckChanged(Object source, int index) {
	             fireContentsChanged(source, index, index);
	         }
	 
	         public Object getItem(int index) {
	             return items[index];
	         }
	     }
	 
	     /**
	     * 这里就覆盖了一个构造函数。其他JList你自己覆盖吧，反正super一下再init就OK了。
	      * @param items Object[]
	      */
	     public JCheckListBox(Object[] items) {
	         setModel(new CheckListBoxModel(items));
	         init();
	    }
	 
	    /**
	      * 初始化控件。包括初始化boolean数组、安装一个渲染器、安装一个鼠标监听器。
	      */
	     protected void init() {
	         checkedItems = new boolean[this.getModel().getSize()];
	         class MyCellRenderer extends JCheckBox implements ListCellRenderer {
	
	             public MyCellRenderer() {
	                 setOpaque(true);
	             }
	 
	             public Component getListCellRendererComponent(
	                     JList list,
	                    Object value,
	                    int index,
	                     boolean isSelected,
	                     boolean cellHasFocus) {
	                 //这点代码基本上从DefaultListCellRenderer.java中抄袭的。
	                setComponentOrientation(list.getComponentOrientation());
	                 if (isSelected) {
	                    setBackground(list.getSelectionBackground());
	                     setForeground(list.getSelectionForeground());
	                 } else {
	                     setBackground(list.getBackground());
	                    setForeground(list.getForeground());
	                 }
	 
	                 if (value instanceof Icon) {
	                     setIcon((Icon) value);
	                    setText("");
	                 } else {
	                     setIcon(null);
	                    setText((value == null) ? "" : value.toString());
	                }
	                 setEnabled(list.isEnabled());
	                setFont(list.getFont());
	 
	                //虽然抄袭，可这里别忘了设置check信息。
	                this.setSelected(isChecked(index));
	                 return this;
	             }
	         }
	 
	         this.setCellRenderer(new MyCellRenderer());
	         //定义一个鼠标监听器。如果点击某个item，翻转其check状态。
	         class CheckBoxListener extends MouseAdapter {
	 
	             @Override
	             public void mouseClicked(MouseEvent e) {
	                 int index = locationToIndex(e.getPoint());
	                 invertChecked(index);
	             }
       }
	
	       this.addMouseListener(new CheckBoxListener());
	    }
	
    /**
	     * 翻转指定item的check状态。
	     * @param index int
	     */
	    public void invertChecked(int index) {
	        checkedItems[index] = !checkedItems[index];
	        //别忘了发送event。
        CheckListBoxModel model = (CheckListBoxModel) getModel();
	        model.fireCheckChanged(this, index);
	        this.repaint();
	    }

	    /**
     * 是否指定item被check。
	    * @param index int
	    * @return boolean
	     */
	    public boolean isChecked(int index) {
	       return checkedItems[index];
	    }
	
	    /**
     * 获得选中的item个数
	     */
	    public int getCheckedCount() {
        int result = 0;
	        for (int i = 0; i < checkedItems.length; i++) {
	            if (checkedItems[i]) {
	               result++;
	            }
	        }
	       return result;
	    }

	    /**
	     * 所有选中item索引的数组。
	     */
	    public int[] getCheckedIndices() {
	       int[] result = new int[getCheckedCount()];
	       int index = 0;
	        for (int i = 0; i < checkedItems.length; i++) {
            if (checkedItems[i]) {
	                result[index] = i;
	                index++;
	            }
	        }
	        return result;
	    }
}
