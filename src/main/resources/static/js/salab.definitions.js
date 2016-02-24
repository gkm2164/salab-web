var SALab = {
	Utility: {},
	Home: {}, Members: {}, Publications: {},
	Research: {}, Activities: {}, Courses: {},
	Resources: {}
};

$.extend(SALab.Utility, {
	namespace: function (ns) {
		var nsarr = [];
		
		nsarr = ns.split (".");
		
		var i = 0,
			iLimit = nsarr.length;
		var parent = this;
		
		for (; i < iLimit; i += 1) {
			var name = nsarr[i];
			if (parent[name] == "undefined") {
				parent[name] = {};
			}
			parent = parent[name];
		}
		
		return parent;
	}
});

$.extend(this, SALab.Utility);
var Browser = this;