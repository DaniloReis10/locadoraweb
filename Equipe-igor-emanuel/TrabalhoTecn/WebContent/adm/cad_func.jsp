<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>FortalCity - Rent a Car</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../style/css_cad.css" />
</head>

<script src="../javascript/cad_cliente.js"></script>

<body>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="row display-table">
                <div class="col-xs-12 col-md-8">
                    <div class="navbar-header navbar-left">
                        <a class="navbar-brand" href="#">
                            <img alt="nucleus" class="img-responsive" src="Assets/logo.png">
                        </a>
                    </div>

                </div>
                <div class="col-xs-5 col-md-5">

                    <ul class="nav nav-pills navbar-right navbar-fixed">
                        <li><a class="btn-style" href="#">Cadastre-se</a></li>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Sobre</a></li>
                        <li><a href="#">Planos</a></li>
                        <li><a href="#">Contato</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <div class="container form-signup">
        <i id="signup-icon" class="fa fa-user-plus fa-4x"></i>
        <h3 id="header-signup"> Novo Colaborador</h3>
            <div class="row">
                <p class="form-content">Nome*</p>
                <input type="text" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{1,}[a-zA-Z]+" required title="Nome inválido" name="name" class="form-input" />
                <p class="form-content"> Sobrenome*</p>
                <input type="text" oninvalid="this.setCustomValidity('Sobrenome inválido')" oninput="setCustomValidity('')" pattern=".{1,}[a-zA-Z]+" required title="Sobrenome inválido" name="last-name" class="form-input" />
                <p class="form-content">Email*</p>
                <input type="email" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{1,}[a-zA-Z]+" required title="Nome inválido" name="email" class="form-input" />
                <p class="form-content">Data de Nascimento*</p>
                <input type="text" oninvalid="this.setCustomValidity('Data inválida')" oninput="setCustomValidity('')" pattern="\d{1,2}/\d{1,2}/\d{4}" required title="Data inválida" class="datepicker form-input" name="date" />
                <p class="form-content"> CPF*</p>
                <input type="text" oninvalid="this.setCustomValidity('Formato de CPF inválido')" oninput="setCustomValidity('')" pattern="\d{3}\d{3}\d{3}\d{2}" required title="Formato de CPF inválido" name="cpf" class="form-input" />
                <p class="form-content"> PIS/PASSEP*</p>
                <input type="text" oninvalid="this.setCustomValidity('Formato de PIS inválido')" oninput="setCustomValidity('')" pattern="\d{3}\d{3}\d{3}\d{2}" required title="Formato de PIS inválido" name="pis" class="form-input" />
                <p class="form-content">Genero*</p>
                <select id="sex-selector" required="" class="form-input" name="sex">
                    <option value="">Selecione o sexo</option>
                    <option value="man">Masculino</option>
                    <option value="fem">Feminino</option>
                </select>
                <p class="form-content">Departamento*</p>
                <select id="dpt-selector" required="" class="form-input" name="dpt">
                    <option value="">Selecione o Departamento</option>
                    <option value="adm">Administração</option>
                    <option value="contab">Contabilidade</option>
                    <option value="vend">Vendas</option>
                    <option value="manu">Manutenção</option>
                </select>
                <p class="form-content">Senha*</p>
                <input type="password" oninvalid="this.setCustomValidity('Mínimo de 6 carácteres')" oninput="setCustomValidity('')" pattern=".{5,}[a-zA-Z|0-9]+" required title="Mínimo de 6 carácteres" name="pwd" class="form-input" />
                <p class="form-content">Digite novamente sua senha*</p>
                <input type="password" name="pwd-conf" required class="form-input" />

            </div>
            <div class="row">
                <div class="col-sm-4 center-col">
                    <p class="form-content">CEP:*</p>
                    <input type="text" required oninvalid="this.setCustomValidity('CEP inválido')" oninput="setCustomValidity('')" pattern="\d{5}-\d{3}" onblur="checkCode(this.value);" required title="CEP inválido" name="zipcode" class="form-input" />
                </div>
                <div class="col-sm-3 center-col">
                    <p class="form-content">Estado*</p>
                    <input type="text" class="form-input" id="state" name="state" disabled />
                </div>
                <div class="col-sm-4 center-col">
                    <p class="form-content">Cidade*</p>
                    <input type="text" class="form-input" id="city" name="city" disabled />
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 center-col">
                    <p class="form-content">Rua*</p>
                    <input type="text" id="street" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{4,}[a-zA-Z]+" required title="Nome inválido" name="street" class="form-input" />
                </div>
                <div class="col-sm-4 center-col">
                    <p class="form-content">Bairro:*</p>
                    <input type="text" id="area" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{4,}[a-zA-Z]+" required title="Nome inválido" name="area" class="form-input" />
                </div>
                <div class="col-sm-3 center-col">
                    <p class="form-content">Numero*</p>
                    <input type="text" required oninvalid="this.setCustomValidity('Número inválido')" oninput="setCustomValidity('')" pattern=".{3,3}[0-9]+" required title="Número inválido" name="number" class="form-input" />
                </div>

            </div>
            
            <input type="button" onclick="cadastrarFuncionario()" class="btn" id="button" value="Registrar Colaborador"></input>

    </div>
    
    </div>

    <footer>
        <div class="container">
            <div class="row center-row display-table">
                <div class="col-xs-12 col-md-8">
                    <h4 class="navbar-text">Contatos:</h4>
                </div>

                <div class="col-xs-6 col-md-4">

                    <ul class="nav navbar-nav navbar-footer navbar-right">
                        <li><a href="#"><span class="social-icons fa fa-facebook-official fa-2x"></span></a></li>
                        <li><a href="#"><span class="social-icons fa fa-instagram fa-2x"></span></a></li>
                        <li><a href="#"><span class="social-icons fa fa-youtube fa-2x"></span></a></li>
                        <li><a href="#"><span class="social-icons fa fa-twitter fa-2x"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="row display-table">
                <div class="col-xs-12 col-md-8">
                    <select>
                        <option value="Estado">Selecione o Escritorio</option>
                    </select>
                </div>
            </div>

    </footer>
</body>

</html>
