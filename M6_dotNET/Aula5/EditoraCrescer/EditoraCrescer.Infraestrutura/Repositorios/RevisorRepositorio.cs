using EditoraCrescer.Infraestrutura.Entidades;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> ObterLista()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor ObterRevisor(int id)
        {
            return contexto.Revisores.FirstOrDefault(a => a.Id == id);
        }

        public Revisor Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
            return revisor;
        }

        public void Alterar(int id, Revisor revisor)
        {
            contexto.Entry(revisor).State = EntityState.Modified;
            contexto.SaveChanges();
        }

        public bool Excluir(int idRevisor)
        {
            Revisor revisor = contexto.Revisores.FirstOrDefault(l => l.Id == idRevisor);
            if (revisor != null)
            {
                contexto.Revisores.Remove(revisor);
                contexto.SaveChanges();
                return true;
            }

            return false;
        }

        public bool RevisorExiste(int id)
        {
            return contexto.Revisores.Count(r => r.Id == id) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
