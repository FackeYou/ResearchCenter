/**
 * @author Kolesnikov
 */

// animation for create case
var cookie = document.cookie;
var matches = document.cookie.match(new RegExp('caseAdd=1'));
if (matches) {
	var divCreateCase = document.getElementById('animationAddCase');
	var div = document.createElement('div');
	var label = document.createElement('label');
	divCreateCase.style.visibility = 'visible';
	div.id = 'animationCreateCase';
	label.innerHTML = 'задача создана';
	label.id = 'animationCCLabel';
	div.style.background = 'green';
	div.style.opacity = 0.0;
	div.appendChild(label);
	divCreateCase.appendChild(div);
	var pause = 0;
	var show = setInterval(function() {
		var op = parseFloat(div.style.opacity);
		if (op != 1.0) {
			div.style.opacity = op + 0.1;
		} else {
			clearInterval(show);
			show = setInterval(function() {
				var op = parseFloat(div.style.opacity);
				if (pause > 20) {
					if (op != 0.0) {
						div.style.opacity = op - 0.1;
					} else {
						clearInterval(show);
						divCreateCase.remove();
					}
				} else
					pause++;
			}, 50);
		}
	}, 50);
	// for delete cookie
	document.cookie = 'caseAdd' + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

// add animation for check-salary module
var helloCase = document.getElementById("helloCase");
var addSalaryPlace = -250;
helloCase.style.right = addSalaryPlace + 'px';
var animationAddCase = setInterval(function() {
	if (addSalaryPlace != 0) {
		addSalaryPlace += 2;
		helloCase.style.right = addSalaryPlace + 'px';
	} else {
		clearInterval(animationAddCase);
	}

}, 5);

// visible and hidden create case border
function showCreateCase() {
	var parent = document.getElementById("parentBlock");
	var typeYes = document.getElementById("yes");
	var typeNo = document.getElementById("no");
	var createCase = document.getElementById("create-case");

	if (createCase.style.visibility.valueOf() == 'hidden'.valueOf())
		createCase.style.visibility = 'visible';
	else {
		createCase.style.visibility = 'hidden';
		parent.style.visibility = "hidden";
		typeYes.checked = undefined;
		typeNo.checked = "checked";
	}
}