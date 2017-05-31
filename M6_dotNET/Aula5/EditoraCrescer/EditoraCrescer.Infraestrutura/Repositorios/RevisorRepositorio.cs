using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public Revisor Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
            return revisor;
        }

        public void Excluir(int idRevisor)
        {
            Revisor revisor = contexto.Revisores.Where(l => l.Id == idRevisor).FirstOrDefault();
            if (revisor != null)
            {
                contexto.Revisores.Remove(revisor);
                contexto.SaveChanges();
            }
        }
    }
}
