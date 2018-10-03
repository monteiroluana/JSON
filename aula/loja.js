$(document).ready(function () {
    console.log("pronto!");

    $('#preco-min').on('input', function () {
        min = $('#preco-min').val();
        $('#valor-min').html(min);
        listarProdutos();
    });

    $('#preco-max').on('input', function () {
        max = $('#preco-max').val();
        $('#valor-max').html(max);
        listarProdutos();
    });

    function carregarProdutos() {
        $.ajax({
            url: 'produtos.json', method: 'GET', success: function (data) {
                console.log(data);
                produtos = data;
                listarProdutos();
            }
        });
    }

    var min = 0;
    var max = 1000;
    var produtos = [];

    function listarProdutos() {
        $('#listaProdutos').html('');
        for (var i = 0; i < produtos.length; i++) {
            var produto = produtos[i];
            if (produto.preco >= min && produto.preco <= max) {
                $('#listaProdutos').append(`<li><a href="#${produto.id}">${produto.nome}</a> R$ - ${produto.preco}</li>`);
            }
        }
        if ($('#listaProdutos').html() === '') {
            $('#listaProdutos').append(`<li class="alert alert-warning" role="alert">Nenhum Produto!</li>`);
        }
    }

    $(window).on('hashchange', function () {
        var hash = window.location.hash;
        var id = hash.substring(1);
        console.log(hash + ' -> ' + id);

        if (id === '') {

            $("#view").load('inicial.html', function () {
                carregarProdutos();
            });

        } else {

            $("#view").load('produto.html', function () {
                 carregarProduto(id);
            });

        }
    });

    $("#view").load('inicial.html', function () {
        carregarProdutos();
    });

    function carregarProduto(id) {
        for (var i = 0; i < produtos.length; i++) {
            var produto = produtos[i];
            if (produto.id == id) {
                $('#nomeProduto').html(produto.nome);
                $('#preco').html(produto.preco);
                break;
            }
        }

    }

});