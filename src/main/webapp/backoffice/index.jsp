<%@page import="com.demoGadd.tusEventos.backoffice.controllers.BackEventoController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 


<h1>BACKOFFICE</h1>
 
 
<span class="text-success">${mensaje }</span> 
<div class="row">
    <div class="col-xl-3 col-sm-6 mb-3">
      <div class="card text-white bg-primary o-hidden h-100">
        <div class="card-body">
          <div class="card-body-icon">
            <i class="fas fa-plus-circle"></i>
          </div>
          <div class="mr-5">Crea un evento nuevo</div>
        </div>
        <a class="card-footer text-white clearfix small z-1" href="backoffice/eventos?op=<%=BackEventoController.OP_NUEVO %>">
          <span class="float-left">Crear</span>
          <span class="float-right">
            <i class="fas fa-angle-right"></i>
          </span>
        </a>
      </div>
    </div>
    
    <div class="col-xl-3 col-sm-6 mb-3">
      <div class="card text-white bg-warning o-hidden h-100">
        <div class="card-body">
          <div class="card-body-icon">
           	<i class="fas fa-list"></i>
          </div>
          <div class="mr-5">Revisar eventos disponibles</div>
        </div>
        <a class="card-footer text-white clearfix small z-1" href="backoffice/eventos">
          <span class="float-left">Ver Listado</span>
          <span class="float-right">
            <i class="fas fa-angle-right"></i>
          </span>
        </a>
      </div>
    </div>
</div>


<%@include file="../includes/footer.jsp"%>
