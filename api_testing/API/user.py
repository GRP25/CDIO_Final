import json, requests

class User:
    def setJson(self, user_id, first_name, sur_name, cpr, initials, roles_id, status):
        roles = []
        for role_id in roles_id:
            if role_id == 1:
                roles.append('Admin')
            elif role_id == 2:
                roles.append('Laborant')
            elif role_id == 3:
                roles.append('Pharmaceut')
            elif role_id == 4:
                roles.append('Produktionsleder')

        self.json = {
                'userID': user_id,
                'firstName': first_name,
                'surname': sur_name,
                'cpr': cpr,
                'initials': initials,
                'status': status,
                'roles': roles
                }

    def get(self, key):
        key = str(key)
        r = requests.get(f"https://api.mama.sh/userresource/{key}")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def delete(self, key):
        key = str(key)
        r = requests.delete(f"https://api.mama.sh/userresource/{key}")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def list(self):
        r = requests.get("https://api.mama.sh/userresource")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def create(self, obj):
        r = requests.post("https://api.mama.sh/userresource", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def update(self, obj):
        r = requests.put("https://api.mama.sh/userresource", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
