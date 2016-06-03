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

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="row display-table">
                <div class="col-xs-12 col-md-8">
                    <div class="navbar-header " style="height:50px;">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" style="position:relative; margin-top:-20px;top:50%;">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">
                            <img alt="nucleus" class="img-responsive" src="assets/logo.png">
                        </a>

                    </div>

                </div>
                <div class="col-xs-5 col-md-8">
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <ul class="nav nav-pills navbar-right navbar-fixed">
                                    <li><a class="btn-style" href="#">Cadastre-se</a></li>
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">Sobre</a></li>
                                    <li><a href="#">Planos</a></li>
                                    <li><a href="#">Contato</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
    </nav>
    <div class="container-fluid form-signup">


        <div class="thumbnail ">
                <div class="row center row">
                    <div class="col-xs-12 col-md-8 center-col">
                        <i id="signup-icon" class="fa fa-user-plus fa-4x img-responsive" style="width:auto; margin-top:32px;"></i>
                        <h3> Cadastre-se</h3>
                        <p class="form-content">Nome*</p>
                        <input type="text" id="nome" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{1,}[a-zA-Z]+" required title="Nome inválido" name="name" class="form-input" />
                        <p class="form-content"> Sobrenome*</p>
                        <input type="text" id="sobrenome" oninvalid="this.setCustomValidity('Sobrenome inválido')" oninput="setCustomValidity('')" pattern=".{1,}[a-zA-Z]+" required title="Sobrenome inválido" name="last-name" class="form-input" />
                        <p class="form-content">Email*</p>
                        <input type="text" id="email" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{1,}[a-zA-Z]+" required title="Nome inválido" name="email" class="form-input" />
                        <p class="form-content">Data de Nascimento*</p>
                        <input type="text" id="nascimento" oninvalid="this.setCustomValidity('Data inválida')" oninput="setCustomValidity('')" required title="Data inválida" class="datepicker form-input" name="date" />

                        <p class="form-content">Genero*</p>
                        <select id="sex-selector" required="" class="form-input" name="sex">
                            <option value="">Selecione o seu sexo</option>
                            <option value="man">Masculino</option>
                            <option value="fem">Feminino</option>
                        </select>
                        <p class="form-content">Senha*</p>
                        <input type="password" id="senha" oninvalid="this.setCustomValidity('Mínimo de 6 carácteres')" oninput="setCustomValidity('')" pattern=".{5,}[a-zA-Z|0-9]+" required title="Mínimo de 6 carácteres" name="pwd" class="form-input" />
                        <p class="form-content">Digite novamente sua senha*</p>
                        <input type="password" name="pwd-conf" required class="form-input" />
                        <p class="form-content">CEP:*</p>
                        <input type="text" id="cep" required oninvalid="this.setCustomValidity('CEP inválido')" oninput="setCustomValidity('')" onblur="checkCode(this.value);" required title="CEP inválido" name="zipcode" class="form-input" />
                        <p class="form-content">Estado*</p>
                        <input type="text" id="estado" class="form-input" id="state" name="state" disabled />
                        <p class="form-content">Cidade*</p>
                        <input type="text" id="cidade" class="form-input" id="city" name="city" disabled />
                        <p class="form-content">Rua*</p>
                        <input type="text" id="street" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{4,}[a-zA-Z]+" required title="Nome inválido" name="street" class="form-input" />
                        <p class="form-content">Bairro:*</p>
                        <input type="text" id="area" required oninvalid="this.setCustomValidity('Nome inválido')" oninput="setCustomValidity('')" pattern=".{4,}[a-zA-Z]+" required title="Nome inválido" name="area" class="form-input" />
                         <p class="form-content">Numero*</p>
                        <input type="text" id="numero" required oninvalid="this.setCustomValidity('Número inválido')" oninput="setCustomValidity('')" pattern=".{3,3}[0-9]+" required title="Número inválido" name="number" class="form-input" />
                         <input type="button" onclick="cadastrarCliente()" class="btn" id="button" value="Criar minha conta"></input>
                    </div>
            </div>

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
                        <option value="Estado">Selecione o Escritório</option>
                    </select>
                </div>
            </div>

    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
