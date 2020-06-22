import requests
import json

class PrescriptionComp:
    def setJson(self, pre_id, com_id, nom_netto, tollerance):
        self.json = {
                'prescription_id': pre_id,
                'commodity_id': com_id,
                'nomNetto': nom_netto,
                'tolerance': tollerance,
                }

    def get(self, pre_id, com_id):
        params = {
                "presID": pre_id,
                "comID": com_id,
                }
        r = requests.get("https://api.mama.sh/PrescriptionComp/component", params=params)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text

    def list(self, *args):
        if len(args) == 1:
            key = str(args[0])
            r = requests.get(f"https://api.mama.sh/PrescriptionComp/{key}")
            try:
                return json.dumps(json.loads(r.text), indent=4)
            except:
                return r.text
        else:
            r = requests.get("https://api.mama.sh/PrescriptionComp")
            try:
                return json.dumps(json.loads(r.text), indent=4)
            except:
                return r.text

    def create(self, obj):
        r = requests.post("https://api.mama.sh/PrescriptionComp", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text

    def update(self, obj):
        r = requests.put("https://api.mama.sh/PrescriptionComp", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
