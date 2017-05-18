var app = angular.module ("Exercicio2", []);
app.controller ("MainController", function ($scope){
    let listaGames = [
    {
        nome: "Quake",
        ano: "1996",
        dev: "idSoftware"},
        {
        nome: "Quake II",
        ano: "1997",
        dev: "idSoftware"},
        {
        nome: "Quake III Arena",
        ano: "1999",
        dev: "idSoftware"},
        {
        nome: "Doom",
        ano: "1993",
        dev: "idSoftware"},
        {
        nome: "Doom 2",
        ano: "1994",
        dev: "idSoftware"},
        {
        nome: "Doom 3",
        ano: "2004",
        dev: "idSoftware"},
        {
        nome: "Doom 2016",
        ano: "2016",
        dev: "idSoftware"},
        {
        nome: "Grand Theft Auto: San Andreas",
        ano: "2004",
        dev: "Rockstar Games"},
        {
        nome: "Grand Theft Auto: Vice City",
        ano: "2002",
        dev: "Rockstar Games"},
        {
        nome: "Grand Theft Auto: IV",
        ano: "2008",
        dev: "Rockstar Games"},
        {
        nome: "Grand Theft Auto: V",
        ano: "2013",
        dev: "Rockstar Games"},
        {
        nome: "Grand Theft Auto",
        ano: "1997",
        dev: "Rockstar Games"},
        {
        nome: "Grand Theft Auto: II",
        ano: "1999",
        dev: "Rockstar Games"},
        {
        nome: "Grand Theft Auto: III",
        ano: "2001",
        dev: "Rockstar Games"},
        {
        nome: "Call of Duty",
        ano: "2001",
        dev: "Infinity Ward"},
        {
        nome: "Call of Duty II",
        ano: "2005",
        dev: "Infinity Ward"},
        {
        nome: "Call of Duty III",
        ano: "2006",
        dev: "Treyarch"},
        {
        nome: "Call of Duty IV: Modern Warfare",
        ano: "2007",
        dev: "Infinity Ward"},
        {
        nome: "Call of Duty World At War",
        ano: "2008",
        dev: "Treyarch"},
        {
        nome: "Call of Duty Modern Warfare II",
        ano: "2009",
        dev: "Infinity Ward"},
        {
        nome: "Call of Duty Modern Warfare III",
        ano: "2011",
        dev: "Infinity Ward & Sledgehammer"},
        {
        nome: "Call of Duty Black Ops",
        ano: "2010",
        dev: "Treyarch"},
        {
        nome: "Call of Duty Black Ops II",
        ano: "2012",
        dev: "Treyarch"},
        {
        nome: "Call of Duty Ghosts",
        ano: "2013",
        dev: "Infinity Ward"},
        {
        nome: "Call of Duty Advanced Warfare",
        ano: "2014",
        dev: "Sledgehammer"},
        {
        nome: "Call of Duty Black Ops III",
        ano: "2015",
        dev: "Treyarch"},
        {
        nome: "Call of Duty Infinite Warfare",
        ano: "2016",
        dev: "Infinity Ward"},
        {
        nome: "Age of Empires",
        ano: "1997",
        dev: "Ensemble Studios"},
        {
        nome: "Age of Empires II: The Age of Kings",
        ano: "1999",
        dev: "Ensemble Studios"},
        {
        nome: "Age of Mythology",
        ano: "2002",
        dev: "Ensemble Studios"},
        {
        nome: "Age of Empires III",
        ano: "2005",
        dev: "Ensemble Studios"},
        {
        nome: "Kerbal Space Program",
        ano: "2011",
        dev: "Squad"},
        {
        nome: "Halo",
        ano: "2001",
        dev: "Bungie"},
        {
        nome: "Halo 2",
        ano: "2004",
        dev: "Bungie"},
        {
        nome: "The Sims 4",
        ano: "2013",
        dev: "Maxis"},
        {
        nome: "The Sims",
        ano: "2000",
        dev: "Maxis"},
        {
        nome: "The Sims 2",
        ano: "2004",
        dev: "Maxis"},
        {
        nome: "The Sims 3",
        ano: "2009",
        dev: "Maxis"},
        {
        nome: "Sim City",
        ano: "1989",
        dev: "Maxis"},
        {
        nome: "Sim City 2000",
        ano: "1994",
        dev: "Maxis"},
        {
        nome: "Sim City 3000",
        ano: "1998",
        dev: "Maxis"},
        {
        nome: "Sim City 4",
        ano: "2003",
        dev: "Maxis"},
       
  ];

  listaGames.sort(function compare(a,b) {
  if (a.nome < b.nome)
    return -1;
  if (a.nome > b.nome)
    return 1;
  return 0;
});

  $scope.games = listaGames;

})