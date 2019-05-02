/*
This function is used to enable the edges to be edited via the property editor
*/
function createEdge(bool) {
  let start = undefined
  let end = undefined
  let p, q
  let fromPoint = undefined
  let toPoint = undefined
  let isSelected = false
  let startArrow = 'None'
  let endArrow = 'None'
  let startLabel = ''
  let middleLabel = ''
  let endLabel = ''
  let bend = 'Straight'

  const panel = document.getElementById('graphpanel')
  const line = document.createElementNS('http://www.w3.org/2000/svg', 'line')

  const vLine = document.createElementNS('http://www.w3.org/2000/svg', 'line')
  const hLine = document.createElementNS('http://www.w3.org/2000/svg', 'line')
  return {
    connect: (s, e) => {
      start = s
      end = e
    },
    getStart:() =>{
      return start
    },
    getEnd:() =>{
      return end
    },
    getBounds: () => {
      return {
        x: p.x,
        y: p.y,
        width: q.x - p.x,
        height: q.y - p.y
      }
    },
    contains: z => {
      //find slope of current line
      p = center(start.getBounds())
      q = center(end.getBounds())
      isSelected = false
      if(bend === "VH"){
        //for when start node is to the left and below end node, vertical line
        if (p.x <= q.x && p.y >= q.y) {
          if (z.x > p.x - 10 && z.x < p.x + 10 && z.y < p.y - 10 && z.y > q.y + 10) {
            isSelected = true
            return true
          }//check horizontal line for when start node is to the left and below end node
          else if (z.y > (q.y - 10) && z.y < (q.y + 10) && z.x > p.x - 10 && z.x < q.x + 10) {
            isSelected = true
            return true
          }
        }
        //find bounds of line 1
        //works for when start node is above end node, looks at vertical line
        if(p.x <= q.x && p.y <= q.y) {
          if (z.x > (p.x - 10) && z.x < p.x + 10 && (z.y > p.y + 10) && (z.y < q.y + 10)) //checking mouse's relationship to line 1
          {
            isSelected = true
            return true
          }
          //find bounds of line 2
          // for when start node is left of end node, looks at horizontal line
          if (z.y > q.y - 10 && z.y < q.y + 10 && z.x > p.x - 10 && z.x < q.x + 10) {
            isSelected = true
            return true
          }
        }
        if(p.x >= q.x && p.y <= q.y) {//when start node is to the right and above end node
          if (z.x < p.x + 10 && z.x > p.x - 10 && z.y > p.y + 10 && z.y < q.y - 10) {
            isSelected = true
            return true
          }//horizontal line
          else if (z.y > q.y - 10 && z.y < q.y + 10 && z.x < p.x + 10 && z.x > q.x - 10) {
            isSelected = true
            return true
          }

        }
        if(p.x > q.x && p.y > q.y) {
          if (z.x > p.x - 10 && z.x < p.x + 10 && z.y < p.y - 10 && z.y > q.y + 10) {
            isSelected = true
            return true
          }
          else if (z.y > q.y - 10 && z.y < q.y + 10 && z.x < p.x + 10 && z.x > q.x - 10) {
            isSelected = true
            return true
          }
        }
      }
      else if(bend === "HV"){
        //for when start node is to the left and below end node, vertical line
        if (p.x <= q.x && p.y >= q.y) {
          if (z.x > p.x - 10 && z.x < p.x + 10 && z.y < p.y - 10 && z.y > q.y + 10) {
            isSelected = true
            return true
          }//check horizontal line for when start node is to the left and below end node
          else if (z.y > (q.y - 10) && z.y < (q.y + 10) && z.x > p.x - 10 && z.x < q.x + 10) {
            isSelected = true
            return true
          }
        }
        //find bounds of line 1
        //works for when start node is above end node, looks at vertical line
        if(p.x <= q.x && p.y <= q.y) {
          if (z.x > (p.x - 10) && z.x < p.x + 10 && (z.y > p.y + 10) && (z.y < q.y + 10)) //checking mouse's relationship to line 1
          {
            isSelected = true
            return true
          }
          //find bounds of line 2
          // for when start node is left of end node, looks at horizontal line
          if (z.y > q.y - 10 && z.y < q.y + 10 && z.x > p.x - 10 && z.x < q.x + 10) {
            isSelected = true
            return true
          }
        }
        if(p.x >= q.x && p.y <= q.y) {//when start node is to the right and above end node
          if (z.x < p.x + 10 && z.x > p.x - 10 && z.y > p.y + 10 && z.y < q.y - 10) {
            isSelected = true
            return true
          }//horizontal line
          else if (z.y > q.y - 10 && z.y < q.y + 10 && z.x < p.x + 10 && z.x > q.x - 10) {
            isSelected = true
            return true
          }

        }
        if(p.x > q.x && p.y > q.y) {
          if (z.x > p.x - 10 && z.x < p.x + 10 && z.y < p.y - 10 && z.y > q.y + 10) {
            isSelected = true
            return true
          }
          else if (z.y > q.y - 10 && z.y < q.y + 10 && z.x < p.x + 10 && z.x > q.x - 10) {
            isSelected = true
            return true
          }
        }
      }
      else
      {///for striaght lines
        let minimumX
        let minimumY
        let maximumX
        let maximumY
        if(p.x > q.x){
          maximumX = p.x
          minimumX = q.x
        }
        else {
          maximumX = q.x
          minimumX = p.x
        }
        if(p.y > q.y) {
          maximumY = p.y
          minimumY = q.y
        }
        else {
          maximumY = q.y
          minimumY = p.y
        }
        if( Math.abs(q.x - p.x) > 10)//does not work if the x's are the same or too close to the same value
        {
          let slope = (q.y - p.y)/(q.x - p.x)
          let yIntercept = q.y - (slope*q.x) //solve for b
          let equation = (slope*z.x) + yIntercept  //find what Y should be given an X to be on the line
          if ( equation >= z.y- 10 && equation <= z.y+10 && z.x >= minimumX-10 && z.x <= maximumX+10 && z.y >= minimumY-10 && z.y <= maximumY+10 ) {
            isSelected = true
            return true
          }
        }
        else if (p.x + 10 >= z.x && p.x - 10 <= z.x && z.y >= minimumY-10 && z.y <= maximumY+10 )//if x = x
        {
          isSelected = true
          return true
        }
        else{
          isSelected = false
          return false
        }
      }
    },
    translate: () => {
      return
    },
    draw: () => {
	line.id = 'solidEdge'
	let p1 = {
	    x: start.getBounds().x,
	    y: start.getBounds().y	    
	}
	let p2 = {
	    x: end.getBounds().x,
	    y: end.getBounds().y	    
	}
	fromPoint = start.getConnectionPoint(p2)
	toPoint = end.getConnectionPoint(p1)
	fromPoint = start.getConnectionPoint(toPoint)
	toPoint = end.getConnectionPoint(fromPoint)

      line.setAttribute('x1', fromPoint.x )
      line.setAttribute('x2', toPoint.x)
      line.setAttribute('y1', fromPoint.y)
      line.setAttribute('y2', toPoint.y )


      line.setAttribute('stroke-width', '1')

      //if lineStyle is set to dotted
      if(bool === 1)
        line.setAttribute('stroke-dasharray', '4', '4')

      panel.append(line)

      //for the edge bend
      if(bend === 'HV')
      {
        line.setAttribute('x1', fromPoint.x)
        line.setAttribute('x2', toPoint.x)
        line.setAttribute('y1', fromPoint.y)
        line.setAttribute('y2', fromPoint.y)
        vLine.setAttribute('stroke', 'black')
        vLine.setAttribute('stroke-width', '1')
        vLine.setAttribute('x1', toPoint.x)
        vLine.setAttribute('x2', toPoint.x)
        vLine.setAttribute('y1', fromPoint.y)
        vLine.setAttribute('y2', toPoint.y)
        panel.append(vLine)
      }
      else if(bend === 'VH')
      {
        line.setAttribute('x1', fromPoint.x)
        line.setAttribute('x2', fromPoint.x)
        line.setAttribute('y1', fromPoint.y)
        line.setAttribute('y2', toPoint.y)
        hLine.setAttribute('stroke', 'black')
        hLine.setAttribute('stroke-width', '1')
        hLine.setAttribute('x1', fromPoint.x)
        hLine.setAttribute('x2', toPoint.x)
        hLine.setAttribute('y1', toPoint.y)
        hLine.setAttribute('y2', toPoint.y)
        panel.append(hLine)
      }

      if(isSelected === true)
      {
        line.setAttribute('stroke', 'darkgrey')
        if(bend === "HV" )
          vLine.setAttribute('stroke', 'darkgrey')
        else if( bend === "VH")
          hLine.setAttribute('stroke', 'darkgrey')
      }
      else {
        line.setAttribute('stroke', 'black')
      }

      //for startArrowHead
      if(startArrow !== 'None')
      {
        startArrowHead(startArrow, fromPoint, toPoint)
      }

      //for endArrowHead
      if(endArrow !== 'None')
      {
        endArrowHead(endArrow, fromPoint, toPoint)
      }

      //add labels to the edges
      if(startLabel !== '')
        edgeLabel('START', startLabel, fromPoint, toPoint)
      if(middleLabel !== '')
        edgeLabel('MIDDLE', middleLabel, fromPoint, toPoint)
      if(endLabel !== '')
        edgeLabel('END', endLabel, fromPoint, toPoint)
    },
    clone: ()=>{
      return createSolidEdge()
    },
    getStartArrowHead: ()=>{
      return startArrow
    },
    setStartArrowHead: s =>{
      startArrow = s
    },
    getStartLabel: ()=>{
      return startLabel
    },
    setStartLabel: sLabel =>{
      startLabel = sLabel
    },
    getMiddleLabel: ()=>{
      return middleLabel
    },
    setMiddleLabel: mLabel =>{
      middleLabel = mLabel
    },
    getEndLabel: ()=>{
      return endLabel
    },
    setEndLabel: eLabel =>{
      endLabel = eLabel
    },
    getEndArrowHead: ()=>{
      return endArrow
    },
    setEndArrowHead: e =>{
      endArrow = e
    },
    getStrokeStyle: () =>{
      if(bool == 0)
        return 'Solid - Type 1 for dashed'
      else
        return 'Dotted - Type 0 for solid'
    },
    setStrokeStyle: b =>{
      if(b == 0){
        line.removeAttribute('stroke-dasharray')
        vLine.removeAttribute('stroke-dasharray')
        hLine.removeAttribute('stroke-dasharray')
        bool = b
      }
      else{
        line.setAttribute('stroke-dasharray', '4', '4')
        vLine.setAttribute('stroke-dasharray', '4', '4')
        hLine.setAttribute('stroke-dasharray', '4', '4')
        bool = b
      }
    },
    getBendStyle:() =>{
      return bend
    },
    setBendStyle: d =>{
      if(d === 'HV')
        bend = 'HV'
      else if(d === 'VH')
        bend = 'VH'
      else
        bend = 'Straight'
    }
  }
}



/*
This function adds a label (input) to the specified location on a line with points p and q
*/
function edgeLabel(location, input, from, to)
{
  const panel = document.getElementById('graphpanel')
    const t = document.createElementNS('http://www.w3.org/2000/svg', 'text' )        
    if(location === 'START')
  {
    t.setAttribute('x', to.x)
    t.setAttribute('y', to.y)
    t.textContent = input
  }
  else if(location === 'MIDDLE')
  {
    t.setAttribute('x', (from.x + to.x) / 2)
    t.setAttribute('y', (from.y + to.y) / 2)
    t.textContent = input
  }
  else if( location === 'END')
  {
    t.setAttribute('x', from.x)
    t.setAttribute('y', from.y)
    t.textContent = input
  }

  t.setAttribute('fill', 'black')
  t.setAttribute('width', 10)
  t.setAttribute('height', 5)
  panel.append(t)
}


function bend(type, p, q)
{
    const vLine = document.createElementNS('http://www.w3.org/2000/svg', 'line')
    const hLine = document.createElementNS('http://www.w3.org/2000/svg', 'line')
    if(bend === 'HV')
      {
        line.setAttribute('x1', p.x)
        line.setAttribute('x2', q.x)
        line.setAttribute('y1', p.y)
        line.setAttribute('y2', p.y)
        vLine.setAttribute('stroke', 'black')
        vLine.setAttribute('stroke-width', '1')
        vLine.setAttribute('x1', q.x)
        vLine.setAttribute('x2', q.x)
        vLine.setAttribute('y1', p.y)
        vLine.setAttribute('y2', q.y)
        panel.append(vLine)
      }
      else if(bend === 'VH')
      {
        line.setAttribute('x1', p.x)
        line.setAttribute('x2', p.x)
        line.setAttribute('y1', p.y)
        line.setAttribute('y2', q.y)
        hLine.setAttribute('stroke', 'black')
        hLine.setAttribute('stroke-width', '1')
        hLine.setAttribute('x1', p.x)
        hLine.setAttribute('x2', q.x)
        hLine.setAttribute('y1', q.y)
        hLine.setAttribute('y2', q.y)
        panel.append(hLine)
      } 
}

/*
This function is used to draw the start arrow head. Type defines the arrow head that will be use: V, Triangle, Diamond, BlackDiamond, or none. p is the first point; q is the second point
*/
function startArrowHead(type, from, to){
  const panel = document.getElementById('graphpanel')
  const path = document.createElementNS('http://www.w3.org/2000/svg', 'path')

  const ARROW_ANGLE = Math.PI /6
  const ARROW_LENGTH = 10

  const dx = to.x - from.x
  const dy = to.y - from.y
  const angle = Math.atan2(dy,dx)
  const x1 = to.x - ARROW_LENGTH * Math.cos(angle + ARROW_ANGLE)
  const y1 = to.y - ARROW_LENGTH * Math.sin(angle + ARROW_ANGLE)
  const x2 = to.x - ARROW_LENGTH * Math.cos(angle - ARROW_ANGLE)
  const y2 = to.y - ARROW_LENGTH * Math.sin(angle - ARROW_ANGLE)

  if(type === 'V')
  {
      path.setAttribute('d', 'M ' + (to.x) + ' ' + (to.y) + ' L ' + (x2) + ' ' + (y2) + ' M ' + (x1) + ' ' + (y1) + ' L' + ' ' + (to.x) + ' ' + (to.y) + '')
  }
  else if (type === 'Triangle')
  {
      path.setAttribute('d', 'M ' + (to.x) + ' ' + (to.y) + ' L ' + (x2) + ' ' + (y2) + ' L ' + (x1) + ' ' + (y1) + ' L' + ' ' + (to.x) + ' ' + (to.y) + '')
      path.setAttribute('fill', 'white')
  }
  else if (type === 'Diamond' || type === 'BlackDiamond')
  {
    const x3 = x2 - ARROW_LENGTH * Math.cos(angle + ARROW_ANGLE)
    const y3 = y2 - ARROW_LENGTH * Math.sin(angle + ARROW_ANGLE)
    if(type === 'Diamond')
    {
      path.setAttribute('d', 'M ' + (to.x) + ' ' + (to.y) + ' L ' + (x2) + ' ' + (y2) + ' L ' + (x3) + ' ' + (y3) + ' L ' + ' ' + (x1) + ' ' + (y1) + ' L ' + ' ' + (to.x) + ' ' + (to.y) + '')
      path.setAttribute('fill', 'white')
    }
    else
    {
      path.setAttribute('d', 'M ' + (to.x) + ' ' + (to.y) + ' L ' + (x2) + ' ' + (y2) + ' L ' + (x3) + ' ' + (y3) + ' L ' + ' ' + (x1) + ' ' + (y1) + ' L ' + ' ' + (to.x) + ' ' + (to.y) + '')
      path.setAttribute('fill', 'black')
    }

  }
  path.setAttribute('stroke', 'black')
  path.setAttribute('stroke-width', 1)
  if(type === 'V')
    path.setAttribute('fill', 'transparent')

  panel.append(path)
}

/*
This function is used to draw the end arrow head. Type defines the arrow head that will be use: V, Triangle, Diamond, BlackDiamond, or none. p is the first point; q is the second point
*/
function endArrowHead(type, from, to)
{
  const panel = document.getElementById('graphpanel')
  const path = document.createElementNS('http://www.w3.org/2000/svg', 'path')

  const ARROW_ANGLE = Math.PI /6
  const ARROW_LENGTH = 10

  const dx = to.x - from.x
  const dy = to.y - from.y
  const angle = Math.atan2(dy,dx)
  const x1 = from.x + ARROW_LENGTH * Math.cos(angle + ARROW_ANGLE)
  const y1 = from.y + ARROW_LENGTH * Math.sin(angle + ARROW_ANGLE)
  const x2 = from.x + ARROW_LENGTH * Math.cos(angle - ARROW_ANGLE)
  const y2 = from.y + ARROW_LENGTH * Math.sin(angle - ARROW_ANGLE)
  if(type === 'V')
  {
    path.setAttribute('d', 'M ' + (from.x) + ' ' + (from.y) + ' L ' + (x2) + ' ' + (y2) + ' M ' + (x1) + ' ' + (y1) + ' L' + ' ' + (from.x) + ' ' + (from.y) + '')
  }
  else if(type === 'Triangle')
  {

      path.setAttribute('d', 'M ' + (from.x) + ' ' + (from.y) + ' L ' + (x2) + ' ' + (y2) + ' L ' + (x1) + ' ' + (y1) + ' L' + ' ' + (from.x) + ' ' + (from.y) + '')
      path.setAttribute('fill', 'white')
  }
  else if(type === 'Diamond' || type === 'BlackDiamond')
  {


    const x3 = x2 + ARROW_LENGTH * Math.cos(angle + ARROW_ANGLE)
    const y3 = y2 + ARROW_LENGTH * Math.sin(angle + ARROW_ANGLE)
    if(type === 'Diamond')
    {

      path.setAttribute('d', 'M ' + (from.x) + ' ' + (from.y) + ' L ' + (x2) + ' ' + (y2) + ' L ' + (x3) + ' ' + (y3) + ' L' + ' ' + (x1) + ' ' + (y1) + ' ' + ' L ' + (from.x) + ' ' + (from.y) + '')
      path.setAttribute('fill', 'white')
    }
    else
    {
      path.setAttribute('d', 'M ' + (from.x) + ' ' + (from.y) + ' L ' + (x2) + ' ' + (y2) + ' L ' + (x3) + ' ' + (y3) + ' L' + ' ' + (x1) + ' ' + (y1) + ' ' + ' L ' + (from.x) + ' ' + (from.y) + '')
      path.setAttribute('fill', 'black')
    }

  }
  path.setAttribute('stroke', 'black')
  path.setAttribute('stroke-width', 1)
  if(type === 'V')
    path.setAttribute('fill', 'transparent')
  panel.append(path)
}



