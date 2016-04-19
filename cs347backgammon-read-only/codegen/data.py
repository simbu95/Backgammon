import structures

Plant = structures.Model('ServerBoard', key='objectID',
  data = [ ['objectID', int],
    ['die1', int],
    ['die2', int],
    ['die3', int],
    ['die4', int],
    ['bar0', int],
    ['point1', int],
    ['point2', int],
    ['point3', int],
    ['point4', int],
    ['point5', int],
    ['point6', int],
    ['point7', int],
    ['point8', int],
    ['point9', int],
    ['point10', int],
    ['point11', int],
    ['point12', int],
    ['point13', int],
    ['point14', int],
    ['point15', int],
    ['point16', int],
    ['point17', int],
    ['point18', int],
    ['point19', int],
    ['point20', int],
    ['point21', int],
    ['point22', int],
    ['point23', int],
    ['point24', int],
    ['bar25', int]],
  functions = [ ['move', [['fromPoint', int], ['toPoint', int]] ],
    ['bearOff', [['fromPoint', int]]],
    ['talk', [ ['message', str] ] ]],
  doc = 'The state of the board on the server'
  )


turnNumber = structures.Global('turnNumber', int)
playerID = structures.Global('playerID', int, 'Player Number; either 0 or 1')
player0Score = structures.Global('player0Score', int, 'Player 0\'s score')
player1Score = structures.Global('player1Score', int, 'Player 1\'s score')
