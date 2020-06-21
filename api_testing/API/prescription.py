import json, requests

class Prescription:
    def setJson(self, name, _id):
        self.json = {
                'prescription_id': _id,
                'prescription_name': name,
                }

    def get(self, key):
        key = str(key)
        r = requests.get(f"https://api.mama.sh/Prescriptions/ID/{key}")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def list(self):
        r = requests.get("https://api.mama.sh/Prescriptions")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def create(self, obj):
        r = requests.post("https://api.mama.sh/Prescriptions", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def update(self, obj):
        r = requests.put("https://api.mama.sh/Prescriptions", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
