
void script(){
var list = document.getElementById("autoriId"); 
        for (var i = 0; i < rows; i++){                
            var opt = table.getValue(i, 0);  
            var li = document.createElement("li");
            var link = document.createElement("a");             
            var text = document.createTextNode(opt);
            link.appendChild(text);
            link.href = "@{'/opera/assign/' + ${autore.getId()} + ${opera.id}}";
            li.appendChild(link);
            list.appendChild(li);
          }
};