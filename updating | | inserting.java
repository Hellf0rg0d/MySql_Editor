@Override
		public void focusGained(FocusEvent e) {
			empty = true;
			initial_row = table.getSelectedRow();
			initial_column = table.getSelectedColumn();
			for(int m = 0;m<table.getColumnCount();m++) {
				try {
				if(table.getValueAt(initial_row, m).toString() == null || table.getValueAt(initial_row, m) == "") {
						empty = true;
				}
				else {
					empty = false;
					break;
				}
			}
			catch(Exception ex) {
			}
			}
			if(empty == false) {
				try {
			initial_text = table.getValueAt(initial_row, initial_column).toString();
				}
				catch(NullPointerException ex) {
					initial_text = null;
						for(int m = 0;m<table.getColumnCount();m++) {
							try {
							if(table.getValueAt(initial_row, m).toString() != null) {
								surrounding_text = table.getValueAt(initial_row, m).toString();
								surrounding_column = m;
								break;
							}
							}
					catch(Exception E) {
						E.printStackTrace();
					}
						}
				}
			}
			
		}
		public void focusLost(FocusEvent e) {
			if(empty == false) {
				try {
					if(initial_text == null) {
								authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(surrounding_column)+" = '"+surrounding_text+"';");
          }
					else {
				authe.stmt.executeUpdate("Update "+authe.table+" set "+table.getColumnName(initial_column)+" = '"+table.getValueAt(initial_row, initial_column).toString()+"' "+"where "+table.getColumnName(initial_column)+" = '"+initial_text+"';");
					}
				}
			
				catch(Exception ex) {
					ex.printStackTrace();
				}}
			else {
				try {
					authe.stmt.executeUpdate("Insert into "+authe.table+" ("+table.getColumnName(initial_column)+") values('"+table.getValueAt(initial_row, initial_column)+"');");
			}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		
		}
	}
	
		
