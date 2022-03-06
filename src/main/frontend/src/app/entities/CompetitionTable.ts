export interface CompetitionTable {
  idStanding: number;
  intRank: number;
  idTeam: number;
  strTeam: string;
  strTeamBadge: string;
  idLeague: number;
  strLeague: string;
  strSeason: string;
  strForm: string;
  strDescription: string;
  intPlayed: number;
  intWin: number;
  intLoss: number;
  intDraw: number;
  intGoalsFor: number;
  intGoalsAgainst: number;
  intGoalDifference: number;
  intPoints: number;
  dateUpdated: string;
}
