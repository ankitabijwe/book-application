$(document).ready(function(){

	$('#pages li a').click(function(){
		if($(this).prop('id')=='first'){
			var sel=1;
			var reset=1;
			readinglist(sel,reset);
		}else if($(this).prop('id')=='last'){
			var sel=parseInt($('#readingcount').val());
			var reset;
			if(sel>3){
				reset=2;
			}else{
				reset=1;
			}
			readinglist(sel,reset);
		}else if($(this).prop('id')=='prev'){
			var sel=parseInt($('#selected').text());
			if(sel>3){
			sel=sel-1;
			var reset=2;
			readinglist(sel,reset);
			}else if(sel==2){
				sel=sel-1;
				var reset=1;
				readinglist(sel,reset);				
			}else{
				if(sel==3){
					sel=sel-1;
					var reset=1;
					readinglist(sel,reset);
				}else{	
				var reset=1;
				readinglist(sel,reset);
				}	
			}
		}else if($(this).prop('id')=='next'){
				var sel=parseInt($('#selected').text());
				if(sel==2){
					sel=sel+1;
					var reset=1;
					readinglist(sel,reset);		
				}else if(sel==1){
					sel=sel+1;
					var reset=1;
					readinglist(sel,reset);			
				}else{
				sel=sel+1;
				var reset=2;
				readinglist(sel,reset);
				}
		}else if($(this).prop('id')==1){
			if($(this).text()==1){
				var sel=parseInt($(this).text());
				var reset=1;
				readinglist(sel,reset);
			}else if($(this).text()==2){
				var sel=parseInt($(this).text());
				var reset=1;
				readinglist(sel,reset);
			}
			else{
				var sel=parseInt($(this).text());
				var reset=2;
				readinglist(sel,reset);
			}
		}else if($(this).prop('id')==2){
			
			if($(this).text()==1){
				var sel=parseInt($(this).text());
				var reset=1;
				readinglist(sel,reset);
			}else if($(this).text()==2){
				var sel=parseInt($(this).text());
				var reset=1;
				readinglist(sel,reset);
			}
			else{
				var sel=parseInt($(this).text());
				var reset=2;
				readinglist(sel,reset);
			}
		}else if($(this).prop('id')==3){
			var sel=parseInt($(this).text());
			var reset=2;
			readinglist(sel,reset);
		}else if($(this).prop('id')==4){
			var sel=parseInt($(this).text());
			var reset=2;
			readinglist(sel,reset);
		}else{
		$('#selected').text($(this).text());
		} 
	});
});
	
	
	
	function readinglist(pageno,reset){
		$.ajax({
			url :'../user/userDetail/'+pageno,
			type : 'GET',
			async : false,
		 			
			success : function(data){
				  $('#loadListUser').html(data);
				  $('#filter').hide();
				  $('#traverselist').prop('hidden',false);
				  if(reset==1){
//					  alert("enter in js 12");
						$('#selected').text(pageno);
						$('#1').text('1');
						$('#2').text('2');
						$('#3').text('3');
						$('#4').text('4');	
						$('#loadListUser').html(data);
						
					}else if(reset==2){
						$('#selected').text(pageno);
						$('#1').text(pageno-2);
						$('#2').text(pageno-1);
						$('#3').text(pageno+1);
						$('#4').text(pageno+2);
						$('#loadListUser').html(data);
					}
			}
		});
    	$('#loadListUser').show();
	}
	
