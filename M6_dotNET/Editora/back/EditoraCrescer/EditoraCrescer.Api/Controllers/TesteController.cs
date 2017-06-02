﻿using EditoraCrescer.Api.App_Start;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [Autenticacao(Roles="Administrador")]
    public class TesteController : ApiController
    {
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(System.Net.HttpStatusCode.OK);
        }
    }
}