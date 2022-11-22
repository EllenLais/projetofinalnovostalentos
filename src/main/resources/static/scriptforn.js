(function(){
    $("#tabfornecedor").on("click",".js-delete", function(){
        let botaoClicado  = $(this);
        $("#btnsim").attr("data-id",botaoClicado.attr("data-id"));
        $("#modalfornecedor").modal("show");
    });

    $("#btnsim").on("click",function(){
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/fornecedor/delete/" + id,
            method: "GET",
            success: function(){
                window.location.href="/fornecedor";
            }
        });
    });


})();