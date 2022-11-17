(function(){
    $("#tabcategorias").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalcategoria").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/categoria/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/categoria";
            }
        });
    });


})();