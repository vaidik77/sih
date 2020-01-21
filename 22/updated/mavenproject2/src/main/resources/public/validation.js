

function number(result)
        {  var t=result;
           var result=result.value;
           console.log(result);
           var len=result.length;
           var b = result.slice(0,len+1); 
           var f; 
           for(var i in b){
            if (b.charCodeAt(i) >= 48 && b.charCodeAt(i) <= 57)
            {
               f= true;
            }
            else{
                alert("Enter number only ");
                f= false;
                t.value="";
                break;
            }
               
           }
           return f;
            
      }