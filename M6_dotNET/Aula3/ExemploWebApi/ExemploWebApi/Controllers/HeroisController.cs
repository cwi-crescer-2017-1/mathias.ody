using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {
        public static int Id = 0;
        public static List<Heroi> herois = new List<Heroi>()
        {
            new Models.Heroi() {Id=Id++,Nome="Goku",Poder = new Models.Poder {Nome="Genki Dama", Dano = 8000 } },
            new Models.Heroi() {Id=Id++,Nome="Thor",Poder = new Models.Poder {Nome="Martelo Atômico", Dano = 12000 } },
            new Models.Heroi() {Id=Id++,Nome="Superan",Poder = new Models.Poder {Nome="Força", Dano = 6000 } },
            new Models.Heroi() {Id=Id++,Nome="Odyn",Poder = new Models.Poder {Nome="Supremo", Dano = int.MaxValue } }
        };

        public IEnumerable<Heroi> Get(int? Id = null)
        {
            if (Id == null)
                return herois;
            else
                return herois.Where(x => x.Id == Id);
        }

        public IHttpActionResult Post(Heroi heroi)
        {
            heroi.Id = Id++;
            herois.Add(heroi);
            return Ok();
        }
    }
}
