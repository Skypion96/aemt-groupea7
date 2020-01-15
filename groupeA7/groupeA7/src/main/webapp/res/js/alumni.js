//function sortTable(){
//	var input, filter, table, tr, td, i, txtValue;
//	  input = document.getElementById("search");
//	  filter = input.value.toUpperCase();
//	  table = document.getElementById("table");
//	  tr = table.getElementsByTagName("tr");
//	  
//	  
//	  for (i = 0; i < tr.length; i++) {
//	    td = tr[i].getElementsByTagName("td")[0];
//	    if (td) {
//	      txtValue = td.textContent || td.innerText;
//	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
//	        tr[i].style.display = "";
//	      } else {
//	        tr[i].style.display = "none";
//	      }
//	    }       
//	  }
//}

function sortTable() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("search");
	filter = input.value.toUpperCase();
	table = document.getElementById("table");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		var abc = 0;
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) == 0) {
				abc = 1;
			} else {
				// tr[i].style.display = "none";
			}
		} 
		td1 = tr[i].getElementsByTagName("td")[1];
		if (td1) {
			txtValue = td1.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) == 0) {
				abc = 1;
			} else {
				//tr[i].style.display = "none";
			}
		}
		if (abc == 1) {
			tr[i].style.display = "";
		}
		else
		{
			tr[i].style.display = "none";
		}
		
		td2 = tr[i].getElementsByTagName("td")[2];
		if (td2) {
			txtValue = td2.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) == 0) {
				abc = 1;
			} else {
				//tr[i].style.display = "none";
			}
		}
		if (abc == 1) {
			tr[i].style.display = "";
		}
		else
		{
			tr[i].style.display = "none";
		}
		
		td4 = tr[i].getElementsByTagName("td")[4];
		if (td4) {
			txtValue = td4.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) == 0) {
				abc = 1;
			} else {
				//tr[i].style.display = "none";
			}
		}
		if (abc == 1) {
			tr[i].style.display = "";
		}
		else
		{
			tr[i].style.display = "none";
		}
	}
}