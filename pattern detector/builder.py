import re
import javalang

def detect_builder(filename):
    # Try to detect using javalang
    with open(filename, 'r') as f:
        try:
            tree = javalang.parse.parse(f.read())
            for path, node in tree.filter(javalang.tree.ClassDeclaration):
                if any(isinstance(m, javalang.tree.MethodDeclaration) and m.name == 'build' for m in node.methods):
                    for field in node.fields:
                        if 'static' in field.modifiers and 'final' in field.modifiers:
                            return True
        except javalang.parser.JavaSyntaxError:
            pass  # ignore syntax errors and try regex instead
    
    # Try to detect using regex
    with open(filename, 'r') as f:
        content = f.read()
        pattern = r'public\s+static\s+class\s+Builder\s*{[\s\S]*?public\s+\w+\s+build\(\)\s*{[\s\S]*?new\s+\w+\s*\((\w|,|\s|\.)+\);[\s\S]*?}\s*}'
        match = re.search(pattern, content)
        return match is not None
